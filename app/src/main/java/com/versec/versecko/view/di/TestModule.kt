package com.versec.versecko.view.di

import androidx.room.Room
import com.versec.domain.repository.UserRepository
import com.versec.domain.usecases.GetUserUseCase
import com.versec.versecko.data.datasource.local.UserLocalDataSource
import com.versec.versecko.data.datasource.local.UserLocalDataSourceImpl
import com.versec.versecko.data.mapper.UserMapper
import com.versec.versecko.data.repository.UserRepositoryImpl
import com.versec.versecko.data.room.AppDatabase
import com.versec.versecko.data.room.UserEntityDAO
import com.versec.versecko.viewmodel.UserViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val roomDatabase = module {

    single { Room.databaseBuilder(
        androidApplication(),
        AppDatabase::class.java,
        "userDB"
    ).build()

    }

    single<UserEntityDAO> {
        val roomDB = get<AppDatabase>()
        roomDB.userEntityDao()
    }
}

val repositoryModule = module {

    //single {UserLocalDataSourceImpl()}
    single<UserLocalDataSource> { UserLocalDataSourceImpl(get()) }

    factory { UserMapper() }

    //single { UserRepositoryImpl(get(), get()) }
    single<UserRepository> { UserRepositoryImpl(get(), get()) }

}

val getUserUseCaseModule = module {

    factory { GetUserUseCase(get()) }
}

val userViewModelModule = module {

    viewModel { UserViewModel(get()) }
}




