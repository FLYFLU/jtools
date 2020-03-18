package com.yyou.tools.controller.sample;

/*@Transactional 加于private方法, 无效
@Transactional 加于未加入接口的public方法, 再通过普通接口方法调用, 无效
@Transactional 加于接口方法, 无论下面调用的是private或public方法, 都有效
@Transactional 加于接口方法后, 被本类普通接口方法直接调用, 无效
@Transactional 加于接口方法后, 被本类普通接口方法通过接口调用, 有效
@Transactional 加于接口方法后, 被它类的接口方法调用, 有效
@Transactional 加于接口方法后, 被它类的私有方法调用后, 有效
        总结: Transactional是否生效, 仅取决于是否加载于接口方法, 并且是否通过接口方法调用(而不是本类调用)*/
public class TransactionController {

}
