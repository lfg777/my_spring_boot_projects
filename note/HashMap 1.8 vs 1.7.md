#HashMap 1.8 vs 1.7

##前言

最近看了很多hashMap分析的文章，大都是要么从原理层面做一些分析，要么部分源码做一些简单的分析，要么做一些零碎的总结，总体来说不太尽如人意。hashMap作为java的一个经典的数据结构，相信没有那个程序员小哥哥没用过的，但可能很多人对hashMap的认识还只是停留在原理层面，或者粗略的看过他的get，put
实现，并没有深入的去研究过他的源码和作者的那些**精妙设计**。希望看过这篇文章之后，能对大家有一点点帮助。本文将已jdk1.8版本的hashMap实现为主，并对比1.7看做了哪些优化。本人不太喜欢大段贴源码的方式，而且源码可以很方便的找到，所以希望大家结合源码来看这篇文章，这样自己扒源码，也更容易提高。

##总体结构

**继承体系**
1.7到1.8 hashMap总体结构没有太大的变化，继承体系依旧是继承AbstractMap,实现Map，Cloneable,Serializable接口

```
HashMap<K,V> extends AbstractMap<K,V> implements Map<K,V>, Cloneable, Serializable
```

**内部属性**
_1.8_

```

```