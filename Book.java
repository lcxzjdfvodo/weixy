package book;

public class Book {
    public String  name;
    public String author;
    public  int price;
    public  String  type;//小说
    public  boolean isBorrowed;//是否被借出

    public Book（String name,String author,int Price,String type){
    this.name=name;
    this.author=author;
    this.price=price;
    this.type=type;
    }
}

