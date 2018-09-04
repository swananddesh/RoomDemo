package com.example.midt_068.roomwordsample.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import com.example.midt_068.roomwordsample.entity.Word;
import java.util.List;

/** ******DAO******
 * In the DAO (Data Access Object), you specify SQL queries and associate them
 * with method calls.
 * The DAO must be an interface or abstract class.
 * Room uses DAO to create a clean API for your code.
 * In short, DAO is a mapping of SQL queries to functions.
 * When you use a DAO, you call the methods, and Room takes care of the rest.
 **/

/** ******LiveData******
 * A data holder class that can be observed. Always holds/caches latest version of data.
 * Notifies its observers when the data has changed. LiveData is lifecycle aware.
 * UI components just observe relevant data and don't stop or resume observation.
 * LiveData automatically manages all of this since it's aware of the relevant lifecycle
 * status changes while observing.*/

@Dao
public interface WordDao {

    @Insert
    void insert(Word word);

    @Query("DELETE FROM word_table")
    void deleteAll();

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    LiveData<List<Word>> getAllWords();
}
