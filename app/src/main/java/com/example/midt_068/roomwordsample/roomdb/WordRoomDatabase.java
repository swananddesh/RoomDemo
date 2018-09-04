package com.example.midt_068.roomwordsample.roomdb;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import com.example.midt_068.roomwordsample.dao.WordDao;
import com.example.midt_068.roomwordsample.entity.Word;

/**
 * Room is a database layer on top of SQLite database. Room takes care of tedious tasks
 * that you used to handle with SQLiteOpenHelper.
 * 1. Room uses the DAO to issue queries to its database.
 * 2. By default, to avoid poor UI performance, Room doesn't allow you to issue database queries on the main thread.
 * 3. Your Room class must be abstract and extend RoomDatabase.
 * 4. Usually, you only need one instance of the Room database for the whole app.
 **/

@Database(entities = {Word.class}, version = 1) //Listing the entities will create tables in the database.
public abstract class WordRoomDatabase extends RoomDatabase {

    public abstract WordDao wordDao();

    private static WordRoomDatabase databaseInstance;

    private WordRoomDatabase() {

    }

    /**
     * Create single object using double check locking method.
     * In this, you will make the Singleton class in the synchronized block if the instance is null.
     * So, the synchronized block will be executed only when the databaseInstance is null and
     * prevent unnecessary synchronization once the instance variable is initialized.*/
    public static WordRoomDatabase getInstance(final Context context) {

        if (databaseInstance == null) {

            synchronized (WordRoomDatabase.class) {

                if (databaseInstance == null) {

                    // Create database here
                    databaseInstance = Room.databaseBuilder(context.getApplicationContext(),
                            WordRoomDatabase.class, "word_database")
                    .build();
                }
            }
        }

        return databaseInstance;
    }
}
