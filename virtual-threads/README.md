# Virtual Threads

## 概要
Virtual Threads は、アプリケーションの動作を仮想スレッドを活用して並列動作を実現できる。  
仮想スレッドを使用することで、コンピュータリソースを効率的に使用することができる。  

#### アーキテクチャイメージ
`Virtual Thread <--> JVM Thread <--> Thread(OS)`  
Virtual Thread と JVM Thread は、1対Mの関係。  
JVM Thread と OS が管理するThread は、1対1の関係。

#### 17 vs 21
Java 17 ではプレビュー機能であったが、Java 21 では正式な実装となった。  

#### 結局何が嬉しいのか
従来の JVM Thread による実装は難易度が高く、バグの作り込み、デバッグのしずらさ、JVM の考慮など扱いにくさが多い。  
-> Virtual Thread の実行スケジューリングは JVM に任されているため、実装が容易になった。  
Virtual Thread により実装の簡素化を実現し、よりアプリケーション本体に注力しやすく、スレッド活用によるパフォーマンス向上が期待できる。  

#### サンプルプログラムについて
以下の内容でサンプルプログラムを用意している。

|項目|詳細|
|:--|:--:|
|Virtual Thread 数|100|
|Task(1VT当たりの実行内容)|文字列出力(生成順番号付き)|

本サンプルプログラムで以下の特徴を理解できる。  
* Virtual Threads の実行スケジューリングは JVM に任されているため、実行順序は保証されない
* 旧タイプの Thread(Classic Thread) 実行よりも高速な処理が実現しやすい

## 参考
* [JEP 444: Virtual Threads](https://openjdk.org/jeps/444)
* [Java Virtual Threads — Easy introduction](https://medium.com/@RamLakshmanan/java-virtual-threads-easy-introduction-44d96b8270f8)
  * -> 内部ロジックの構成図がわかりやすい
* [Java Document | Thread](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Thread.html)