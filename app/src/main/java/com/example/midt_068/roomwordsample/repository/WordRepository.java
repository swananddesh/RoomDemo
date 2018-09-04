package com.example.midt_068.roomwordsample.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import com.example.midt_068.roomwordsample.dao.WordDao;
import com.example.midt_068.roomwordsample.entity.Word;
import com.example.midt_068.roomwordsample.roomdb.WordRoomDatabase;
import java.util.List;


/**
 * A Repository manages query threads and allows you to use multiple backends.
 * In short, the Repository implements the logic for deciding whether to fetch data
 * from a network or use results cached in a local database.
 **/
public class WordRepository {

    private WordDao wordDao;

    private LiveData<List<Word>> allWords;

    public WordRepository(Application application) {

        WordRoomDatabase db = WordRoomDatabase.getInstance(application);

        wordDao = db.wordDao();

        allWords = wordDao.getAllWords();
    }

    LiveData<List<Word>> getAllWords() {

        return allWords;
    }

    public void insert(Word word) {

        new InsertAsyncTask(wordDao).execute(word);
    }

    private static class InsertAsyncTask extends AsyncTask<Word, Void, Void> {

        private WordDao mAsyncTaskDao;

        public InsertAsyncTask(WordDao mAsyncTaskDao) {
            this.mAsyncTaskDao = mAsyncTaskDao;
        }

        @Override
        protected Void doInBackground(final Word... word) {
            mAsyncTaskDao.insert(word[0]);
            return null;
        }
    }
}
