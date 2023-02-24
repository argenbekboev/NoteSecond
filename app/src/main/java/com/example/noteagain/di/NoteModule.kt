package com.example.noteagain.di

import android.content.Context
import androidx.room.Room
import com.example.noteagain.data.lacaldb.NoteDao
import com.example.noteagain.data.lacaldb.NoteDataBase
import com.example.noteagain.data.model.NoteEntity
import com.example.noteagain.data.repository.NoteRepositoryImpl
import com.example.noteagain.domain.repository.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NoteModule {

@Singleton
@Provides
fun provideNoteDataBase(
    @ApplicationContext context: Context
):NoteDataBase = Room.databaseBuilder(
        context,
        NoteDataBase::class.java
        ,"note_db"
    ).build()

    @Singleton
    @Provides
    fun provideNoteDao(noteDataBase: NoteDataBase) = noteDataBase.noteDao()

        @Provides
    fun provideNoteRepository(noteDao: NoteDao): NoteRepository = NoteRepositoryImpl(noteDao)

}