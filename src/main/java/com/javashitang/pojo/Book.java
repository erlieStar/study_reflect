package com.javashitang.pojo;

/**
 * @Author: lilimin
 * @Date: 2020/2/20 14:33
 */
public class Book {

    private String name;
    private String author;

    public Book() {
    }

    private Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    private String printTip() {
        return "这是一个私有方法";
    }
}
