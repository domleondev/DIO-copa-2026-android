package me.dio.copa.catar.local.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.dio.copa.catar.data.source.MatchesDataSource
import me.dio.copa.catar.local.source.MatchDataSourceLocal
import javax.inject.Singleton

private const val PREFERENCES_NAME = "notifications_prefs"
private val Context.dataStore by preferencesDataStore(name = PREFERENCES_NAME)

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalModule {

    @Binds
    abstract fun bindsMatchDataSourceLocal(
        impl: MatchDataSourceLocal
    ): MatchesDataSource.Local

    companion object {

        @Provides
        @Singleton
        fun providesDataStore(
            context: Context
        ): DataStore<Preferences> = context.dataStore
    }
}
