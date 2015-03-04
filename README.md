【Android Demo】倒计时

在 Android 系统中UI操作并不是线程安全的，如果多个线程并发的去操作同一个组件，可能导致线程安全问题。
为了解决这一个问题，Android 制定了一条规则：
只允许 UI 线程来修改 UI 组件的属性等，也就是说必须单线程模型，
这样导致如果在 UI 界面进行一个耗时叫长的数据更新等就会形成程序假死现象也就是 ANR 异常，
如果20秒中没有完成程序就会强制关闭。
所以比如另一个线程要修改UI组件的时候，就需要借助 Handler 消息机制了。

核心内容：
1.UI 布局
2.Handler 创建
3.计时器创建
4.逻辑实现
