package com.example.midt_068.roomwordsample.entity;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;


/**
 * The data for this app words, and each word is an Entity.
 * To make the Word class meaningful to Room database, you need to annotate it.
 * @Entity : When working with Architecture Components, this is an annotated class that describes a database table.
 * @PrimaryKey : Every entity needs a primary key.
 * @NonNull : Denotes that a parameter, field, or method return value can never be null.
 * @ColumnInfo : Specify the name of the column in the table
 * */

@Entity(tableName = "word_table")
public class Word {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")
    private String mWord;

    public Word(@NonNull String mWord) {
        this.mWord = mWord;
    }

    public String getmWord() {
        return mWord;
    }
}
