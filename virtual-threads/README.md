# JEP 444: Virtual Threads

## 概要

< comming soon >

### 1. アーキテクチャイメージ

< comming soon >

### 2. Java 17 vs Java 21

* Java 17: プレビュー機能
* Java 21: 正式実装  

### 3. 何が嬉しいのか

< comming soon >  

### 4. サンプルプログラムについて

仮想スレッド と JVM スレッドによりタスクを実行するサンプルプログラム  
以下の内容を理解・確認できる。  

* **パフォーマンス比較**(実行時間、メモリ使用量)
* 実行順序の保証がされない  

また、スレッド上で実行するタスクは以下の通り。

* テキストファイル(sample.txt)に以下の文字列を書き込む処理
  * Hello World! on Virtual Thread [番号]
  * Hello World! on JVM Thread [番号]

※番号：スレッドが生成された順番を示す

#### 4.1. 実行方法

実行環境により結果は異なる

```bash
$ javac ExampleJVMThread.java
$ java ExampleJVMThread <スレッド数>
===JVM Threads===
  Executing Time: 30 (ms)
  Used Memory: 19215688 (bytes)

$ javac ExampleVirtualThread.java
$ java ExampleVirtualThread
===Virtual Threads===
  Executing Time: 31 (ms)
  Used Memory: 6307144 (bytes)
```

#### 4.2. サンプルプログラムの分類

* Task.java: スレッドにて実行される処理(タスク)
* ExampleJVMThread.java: JVMスレッドを使用したシンプルなサンプルプログラム
* ExampleJVMThread2.java: FactoryインスタンスでJVMスレッドを生成したサンプルプログラム
* ExampleVirtualThread.java: Virtualスレッドを使用したシンプルなサンプルプログラム
* ExampleVirtualThread2.java: FactoryインスタンスでVirtualスレッドを生成したサンプルプログラム

##### 注意事項

実行環境により精度が大きく異なる可能性があるため、注意すること。  
特に処理時間やメモリ使用量は、環境の影響を受けやすい。

## 参考

* [JEP 444: Virtual Threads](https://openjdk.org/jeps/444)
* [Java Virtual Threads — Easy introduction](https://medium.com/@RamLakshmanan/java-virtual-threads-easy-introduction-44d96b8270f8)
  * -> 内部ロジックの構成図がわかりやすい
* [Java Document | Thread](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Thread.html)
