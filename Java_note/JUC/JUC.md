# JUC 并发编程

# 1. JUC



# 2. 多线程状态



线程有如下几种状态：

| 状态          | 说明 |
| ------------- | ---- |
| NEW           |      |
| RUNNABLE      |      |
| BLOCKED       |      |
| WAITING       |      |
| TIMED_WAITING |      |
| THERMINATED   |      |
|               |      |



在 Thread 的内部枚举类 State 中：



```
/**
     * A thread state.  A thread can be in one of the following states:
     * <ul>
     * <li>{@link #NEW}<br>
     *     A thread that has not yet started is in this state.
     *     </li>
     * <li>{@link #RUNNABLE}<br>
     *     A thread executing in the Java virtual machine is in this state.
     *     </li>
     * <li>{@link #BLOCKED}<br>
     *     A thread that is blocked waiting for a monitor lock
     *     is in this state.
     *     </li>
     * <li>{@link #WAITING}<br>
     *     A thread that is waiting indefinitely for another thread to
     *     perform a particular action is in this state.
     *     </li>
     * <li>{@link #TIMED_WAITING}<br>
     *     A thread that is waiting for another thread to perform an action
     *     for up to a specified waiting time is in this state.
     *     </li>
     * <li>{@link #TERMINATED}<br>
     *     A thread that has exited is in this state.
     *     </li>
     * </ul>
     *
     * <p>
     * A thread can be in only one state at a given point in time.
     * These states are virtual machine states which do not reflect
     * any operating system thread states.
     *
     * @since   1.5
     * @see #getState
     */
```



```Java


public enum State {
    /**
         * Thread state for a thread which has not yet started.
         */
    NEW,

    /**
         * Thread state for a runnable thread.  A thread in the runnable
         * state is executing in the Java virtual machine but it may
         * be waiting for other resources from the operating system
         * such as processor.
         */
    RUNNABLE,

    /**
         * Thread state for a thread blocked waiting for a monitor lock.
         * A thread in the blocked state is waiting for a monitor lock
         * to enter a synchronized block/method or
         * reenter a synchronized block/method after calling
         * {@link Object#wait() Object.wait}.
         */
    BLOCKED,

    /**
         * Thread state for a waiting thread.
         * A thread is in the waiting state due to calling one of the
         * following methods:
         * <ul>
         *   <li>{@link Object#wait() Object.wait} with no timeout</li>
         *   <li>{@link #join() Thread.join} with no timeout</li>
         *   <li>{@link LockSupport#park() LockSupport.park}</li>
         * </ul>
         *
         * <p>A thread in the waiting state is waiting for another thread to
         * perform a particular action.
         *
         * For example, a thread that has called {@code Object.wait()}
         * on an object is waiting for another thread to call
         * {@code Object.notify()} or {@code Object.notifyAll()} on
         * that object. A thread that has called {@code Thread.join()}
         * is waiting for a specified thread to terminate.
         */
    WAITING,

    /**
         * Thread state for a waiting thread with a specified waiting time.
         * A thread is in the timed waiting state due to calling one of
         * the following methods with a specified positive waiting time:
         * <ul>
         *   <li>{@link #sleep Thread.sleep}</li>
         *   <li>{@link Object#wait(long) Object.wait} with timeout</li>
         *   <li>{@link #join(long) Thread.join} with timeout</li>
         *   <li>{@link LockSupport#parkNanos LockSupport.parkNanos}</li>
         *   <li>{@link LockSupport#parkUntil LockSupport.parkUntil}</li>
         * </ul>
         */
    TIMED_WAITING,

    /**
         * Thread state for a terminated thread.
         * The thread has completed execution.
         */
    TERMINATED;
}
```





# 10. 阻塞队列

阻塞

队列

![image-20200523215915576](JUC.assets/image-20200523215915576.png)

阻塞队列：

![image-20200523220102682](JUC.assets/image-20200523220102682.png)

![image-20200523221222225](JUC.assets/image-20200523221222225.png)

**BlockingQueue** 不是新的东西：

什么情况下我们会使用阻塞队列：多线程并发处理，线程池

学会使用队列：

添加，移除。

四组API

| 方式       | 抛出异常    | 有返回值   | 阻塞等待 | 超时等待    |
| ---------- | ----------- | ---------- | -------- | ----------- |
| 添加       | `add(E)`    | `offer(E)` | `put()`  | `offer(,,)` |
| 移除       | `remove()`  | `poll()`   | `take()` | `poll(,)`   |
| 判断队列首 | `element()` | `peek()`   | -        | -           |



1. 抛出异常

```Java
/**
     * Throws exception
     */
@Test
public void testAddRemove(){
    // queue size
    ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

    System.out.println(blockingQueue.add("a"));
    System.out.println(blockingQueue.add("b"));
    System.out.println(blockingQueue.add("c"));
    // IllegalStateException: Queue full
    // System.out.println(blockingQueue.add("c"));

    System.out.println("=====================================");
    System.out.println(blockingQueue.remove());
    System.out.println(blockingQueue.remove());
    System.out.println(blockingQueue.remove());
    // NoSuchElementException
    System.out.println(blockingQueue.remove());
}
```



2. 不会抛出异常

```Java
/**
    * Return false
    */
@Test
public void testOfferPoll() {
    ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
    System.out.println(blockingQueue.offer("a"));
    System.out.println(blockingQueue.offer("b"));
    System.out.println(blockingQueue.offer("c"));
    // returns false, does not throw a exception
    System.out.println(blockingQueue.offer("d"));

    System.out.println("=====================================");
    System.out.println(blockingQueue.peek());
    System.out.println(blockingQueue.poll());
    System.out.println(blockingQueue.poll());
    System.out.println(blockingQueue.poll());
    // returns null, does not throw a exception
    System.out.println(blockingQueue.poll());
}
```



3. 阻塞等待

```Java
/**
* wait, block
*/
@Test
public void testPutTake() throws InterruptedException {
    ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
    // blocking
    blockingQueue.put("a");
    blockingQueue.put("b");
    blockingQueue.put("c");

    //        blockingQueue.put("d");   // have no place to put a new element, blocking
    System.out.println(blockingQueue.take());
    System.out.println(blockingQueue.take());
    System.out.println(blockingQueue.take());
    //        System.out.println(blockingQueue.take()); // blocking until take element
}
}

```



4. 超时等待

```Java
/**
*  wait, block (timeout)
*/
@Test
public void testOfferPeek2() throws InterruptedException {
    ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue(3);
    blockingQueue.offer("a");
    blockingQueue.offer("b");
    blockingQueue.offer("c");
    blockingQueue.offer("d", 2, TimeUnit.SECONDS);      // wait 2 seconds and exit
    System.out.println("============================");
    System.out.println(blockingQueue.poll());
    System.out.println(blockingQueue.poll());
    System.out.println(blockingQueue.poll());
    System.out.println(blockingQueue.poll(2, TimeUnit.SECONDS));    // wait 2 seconds and exit
}
```

