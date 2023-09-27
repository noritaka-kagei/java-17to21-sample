# Unnamed Classes and Instance Main Methods

## 概要

クラスの定義や main 関数の定義における記述が簡潔に表現できるようになった。  

Virtual Threads は、アプリケーションの動作を仮想スレッドを活用して並列動作を実現できる。  
仮想スレッドを使用することで、コンピュータリソースを効率的に使用することができる。  

### アーキテクチャイメージ

特になし

### 17 vs 21

Java 21 のプレビュー機能として追加された。  

従来の記述スタイル(Java 17)

```java
public class Hoge {
    public static void main(String[] args) {}
}
```

最新の記述スタイル(Java 21)

```java
class Hoge {
    void main() {}
}
```

### 何が嬉しいのか

クラスの定義や main 関数の定義などがより簡潔に表現できるようになったことで、  
Java 初学者には理解しにくい または、学習しなければならなかった以下の観点で、  
スムーズな Java 学習の弊害となり得た。

* アクセス修飾子 (**public**, protected, private, デフォルト)
* その他の修飾子 (**static**, final, abstract...)

### サンプルプログラムについて

* OldStyle.java: 従来の記述(定義)
* NewStyle.java: 本新機能を使用した記述(定義)

サンプルプログラムの実行例は以下の通り。  
(本機能はプレビュー機能のため、プレビュー機能を有効化するオプションが必要)  

```bash
javac  --release 21 --enable-preview NewStyle.java
java --enable-preview NewStyle
```

## 参考

* [JEP 445: ](https://openjdk.org/jeps/445)
