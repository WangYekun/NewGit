# 类加载机制与JDK调优监控工具

Java运行时编译源码(.java)成字节码，由jre运行。jre由java虚拟机实现。JVM分析字节码，后解释并执行

![java编译](D:\work\Course\TyporaImages\JVM\java编译.jpg)

## 类的生命周期

![类加载](D:\work\Course\TyporaImages\JVM\类加载.jpg)

### 1.加载

将.class文件从磁盘读到内存

### 2.连接

#### 2.1 验证

验证字节码文件的正确性

#### 2.2 准备

给类的静态变量分配内存，并赋予默认值

#### 2.3 解析

类装载器装入类所引用的其它所有类

### 3.初始化

为类的静态变量赋予正确的初始值，上述的准备阶段为静态变量赋予的是虚拟机默认的初始值，此处赋予的才是程序编写者为变量分配的真正的初始值，执行静态代码块

### 4.使用

### 5.卸载

## 类加载器的种类

#### 启动类加载器(Bootstrap ClassLoader)

负责加载JRE的核心类库，如JRE目标下的rt.jar，charsets.jar等

#### 扩展类加载器(Extension ClassLoader)

负责加载JRE扩展目录ext中jar类包

#### 系统类加载器(Application ClassLoader) 

负责加载ClassPath路径下的类包

#### 用户自定义加载器(User ClassLoader)

负责加载用户自定义路径下的类包

![类加载器](D:\work\Course\TyporaImages\JVM\类加载器.jpg)

## 类加载机制

#### 全盘负责委托机制

当一个ClassLoader加载一个类的时候，除非显示的使用另一个ClassLoader，该类所依赖和引用的类也由这个ClassLoader载入

#### 双亲委派机制

指先委托父类加载器寻找目标类，在找不到的情况下载自己的路径中查找并载入目标类

##### 双亲委派模式的优势

- 沙箱安全机制：比如自己写的String.class类不会被加载，这样可以防止核心库被随意篡改
- 避免类的重复加载：当父ClassLoader已经加载了该类的时候，就不需要子CJlassLoader再加载一次

## JVM性能调优监控工具

### Jinfo

查看正在运行的Java程序的扩展参数

#### 查看JVM的参数

![jinfo1](D:\work\Course\TyporaImages\JVM\jinfo1.png)

#### 查看java系统属性

等同于System.getProperties()

![jinfo2](D:\work\Course\TyporaImages\JVM\jinfo2.png)

### Jstat

jstat命令可以查看堆内存各部分的使用量，以及加载类的数量。命令格式：

jstat [-命令选项] [vmid] [间隔时间/毫秒] [查询次数]

#### 类加载统计

![jstat1](D:\work\Course\TyporaImages\JVM\jstat1.png)

- Loaded：加载class的数量
- Bytes：所占用空间大小
- Unloaded：未加载数量
- Bytes：未加载占用空间
- Time：时间

#### 垃圾回收统计

![img](file:///C:\Users\colde\AppData\Roaming\Tencent\Users\2456994185\QQ\WinTemp\RichOle\@S`WOH1AS0QSVH[@TN%[648.png)

- S0C：第一个Survivor区的空间
- S1C：第二个Survivor区的空间
- S0U：第一个Survivor区的使用空间
- S1U：第二个Survivor区的使用空间
- EC：Eden区的总空间
- EU：Eden区的使用空间
- OC：Old区的总空间
- OU：Old区的已使用空间
- MC：元空间的总空间
- MU：元空间的使用空间
- CCSC：压缩类的总空间
- CCSU：压缩类的使用空间
- YGC：年轻代垃圾回收次数
- YGCT：年轻代垃圾回收消耗时间
- FGC：老年代垃圾回收次数
- FGCT：老年代垃圾回收消耗时间
- GCT：垃圾回收消耗总时间

#### 堆内存统计

![jstat3](D:\work\Course\TyporaImages\JVM\jstat3.png)

- NGCMN：新生代最小空间
- NGCMX：新生代最大空间
- NGC：当前新生代空间
- S0C：第一个Survivor区空间
- S1C：第二个Survivor区空间
- EC：Eden区的总空间
- OGCMN：老年代最小空间
- OGCMX：老年代最大空间
- OGC：当前老年代空间
- OC：当前老年代空间
- MCMN：最小元空间大小
- MCMX：最大元空间大小
- MC：当前元空间大小
- CCSMN：最小压缩类空间大小
- CCSMX：最大压缩类空间大小
- CCSC：当前压缩类空间大小
- YGC：年轻代GC次数
- FGC：老年代GC次数

#### 新生代垃圾回收统计

![jstat4](D:\work\Course\TyporaImages\JVM\jstat4.png)

- S0C：第一个Survivor区空间
- S1C：第二个Survivor区空间
- S0U：第一个Survivor区的使用空间
- S1U：第二个Survivor区的使用空间
- TT：对象在新生代存活的次数
- MTT：对象在新生代存活的最大次数
- DSS：期望Survivor区大小
- EC：Eden区的空间
- EU：Eden区的使用空间
- YGC：年轻代垃圾回收次数
- YGCT：年轻代垃圾回收消耗时间

#### 新生代内存统计

![jstat5](D:\work\Course\TyporaImages\JVM\jstat5.png)

- NGCMN：新生代最小空间
- NGCMX：新生代最大空间
- NGC：当前新生代空间
- S0CMX：最大第一个Survivor区空间
- S0C：当前第一个Survivor区空间
- S1CMX：最大第二个Survivor区空间
- S1C：当前第二个Survivor区空间
- ECMX：最大Eden区空间
- EC：当前Eden区空间
- YGC：年轻代垃圾回收次数
- FGC：老年代垃圾回收次数

#### 老年代垃圾回收统计

![jstat6](D:\work\Course\TyporaImages\JVM\jstat6.png)

- MC：元空间的总空间
- MU：元空间的使用空间
- CCSC：压缩类的总空间
- CCSU：压缩类的使用空间
- OC：Old区的总空间
- OU：Old区的已使用空间
- YGC：年轻代GC次数
- FGC：老年代GC次数
- FGCT：老年代垃圾回收消耗时间
- GCT：垃圾回收消耗总时间

#### 老年代内存统计

![jstat7](D:\work\Course\TyporaImages\JVM\jstat7.png)

- OGCMN：老年代最小空间
- OGCMX：老年代最大空间
- OGC：当前老年代空间
- OC：当前老年代空间
- YGC：年轻代GC次数
- FGC：老年代GC次数
- FGCT：老年代垃圾回收消耗时间
- GCT：垃圾回收消耗总时间

#### 元空间内存统计

![jstat8](D:\work\Course\TyporaImages\JVM\jstat8.png)

- MCMN：最小元空间大小
- MCMX：最大元空间大小
- MC：当前元空间大小
- CCSMN：最小压缩类空间大小
- CCSMX：最大压缩类空间大小
- CCSC：当前压缩类空间大小
- YGC：年轻代GC次数
- FGC：老年代GC次数
- FGCT：老年代垃圾回收消耗时间
- GCT：垃圾回收消耗总时间

#### 总垃圾回收统计

![jstat9](D:\work\Course\TyporaImages\JVM\jstat9.png)

- S0：第一个Survivor区当前使用比例
- S1：第二个Survivor区当前使用比例
- E：Eden区使用比例
- O：Old区使用比例
- M：元空间使用比例
- CCS：压缩使用比例
- YGC：年轻代垃圾回收次数
- FGC：老年代垃圾回收次数
- FGCT：老年代垃圾回收消耗时间
- GCT：垃圾回收消耗总时间

### Jmap

可以用来查看内存信息

#### 堆的对象统计

```
jmap -histo 7824 > xxx.txt
```

如图：

![jmap1](D:\work\Course\TyporaImages\JVM\jmap1.png)

- Num：序号
- Instances：实例数量
- Bytes：占用空间大小
- Class Name：类名

#### 堆信息

![jmap2](D:\work\Course\TyporaImages\JVM\jmap2.png)

#### 堆内存dump

![jmap3](D:\work\Course\TyporaImages\JVM\jmap3.png)

也可以在设置内存溢出的时候自动导出dump文件（内存很大的时候，可能会导不出来）

1.-XX:+HeapDumpOnOutOfMemoryError

2.-XX:HeapDumpPath=输出路径

```
-Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=d:\oomdump.dump
```

![jmap4](D:\work\Course\TyporaImages\JVM\jmap4.png)

可以使用jvisualvm命令工具导入文件分析

![jmap5](D:\work\Course\TyporaImages\JVM\jmap5.png)

### Jstack

jstack用于生成java虚拟机当前时刻的线程快照。

![jstack](D:\work\Course\TyporaImages\JVM\jstack.png)