package com.yyou.tools.util;

public class SnowFlake implements IdGenerator{
//    机房id
    private final long storeId;
    private final long machineId;
    private long sequence;

    private final static int sequenceLength = 12;
    private final static int machineLength = 5;
    private final static int storeLength = 5;
//    private final static int sequenceOffset = sequenceLength;
    private final static int machineOffset = sequenceLength;
    private final static int storeOffset = machineOffset + machineLength;
    private final static int timestampOffset = storeOffset+storeLength;
//     还有种写法-1L ^ (-1L << sequenceLength)，
//     与补码等有关
//    涉及补码，反码,最高位表示符号,1为负数
//    对于一个负数 如-1,
//    原码 1000-0001
//    反码 1111-1110
//    补码 1111-1111
//    -1<<2 = 1000-0100 反码1111-1011,补码1111-1100
//    -1^(-1<<2) 1111-1100^1111-1111 = 0000-0011 ,结果为正数,补码就是本身,为3
    private final static long sequenceSeed =0xFFF;
//    1288834974657 是 (Thu, 04 Nov 2010 01:42:54 GMT) 这一时刻到1970-01-01 00:00:00时刻所经过的毫秒数。
//    当前时刻减去1288834974657 的值刚好在2^41 里，因此占41位。 所以这个数是为了让时间戳占41位才特地算出来的。
    private final static long initTimestamp = 1288834974657L;

    private long lastGenerateTimestamp = -1L;

    public SnowFlake(long storeId, long machineId, long sequence) {
        if (storeId <= 0) {
            throw new IllegalArgumentException(
                    String.format("storeid must greate than 0,id %d", storeId));
        }
        if (machineId <= 0) {
            throw new IllegalArgumentException(
                    String.format("machineId must greate than 0,id %d", machineId));
        }
        if (sequence <= 0) {
            throw new IllegalArgumentException(
                    String.format("sequence must greate than 0,id %d", sequence));
        }
        this.storeId = storeId;
        this.machineId = machineId;
        this.sequence = sequence;
    }

    private long getTimeSequence(long timestamp){
//        long seq = 0;
        if(lastGenerateTimestamp==timestamp){
            sequence = getTimestampSync();
        }else {
            sequence = 0;
        }
        return sequence;
    }

    private synchronized long getTimestampSync(){
        sequence = ++sequence&sequenceSeed;
        return sequence;
    }

    private long getTimeMillis(){
        lastGenerateTimestamp = System.currentTimeMillis()-initTimestamp;
        return lastGenerateTimestamp;
    }


    @Override
    public long getId() {
        long timestamp = getTimeMillis();
        long seq = getTimeSequence(timestamp);
        long snowFlakeId = timestamp<<timestampOffset|
                storeId<<storeOffset|
                machineId<<machineOffset|
                seq;
        return snowFlakeId;
    }
}
