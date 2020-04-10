package com.ahmednts.scylla.repository.impl3

import io.reactivex.Flowable

class User

interface UserRepository {

  fun getUser(userId: String): Flowable<User>

  fun setUser(user: User)
}

class DefaultUserRepo(retrofit: String, db: String) : UserRepository {

  override fun getUser(userId: String): Flowable<User> {
    TODO("Implementation goes here")
  }

  override fun setUser(user: User) {
    TODO("Implementation goes here")
  }
}

class RemoteUserRepo(retrofit: String) : UserRepository {

  override fun getUser(userId: String): Flowable<User> {
    TODO("Implementation goes here")
  }

  //useless
  override fun setUser(user: User) {
    TODO("not implemented")
  }
}

class LocalUserRepo(db: String) : UserRepository {

  override fun getUser(userId: String): Flowable<User> {
    TODO("Implementation goes here")
  }

  override fun setUser(user: User) {
    TODO("Implementation goes here")
  }
}

class GetUserUseCase(private val repository: UserRepository) {
  fun getUser(userId: String) = repository.getUser(userId)
}

class SetUserUseCase(private val repository: UserRepository) {
  fun setUser(user: User) = repository.setUser(user)
}

fun main() {

  val remoteDS = "retrofit"
  val remoteRepo = RemoteUserRepo(remoteDS)

  val localDS = "realmDB"
  val localRepo = LocalUserRepo(localDS)

  val repo = DefaultUserRepo(remoteDS, localDS)

  GetUserUseCase(remoteRepo).getUser("")
  GetUserUseCase(localRepo).getUser("")
  GetUserUseCase(repo).getUser("")

//  not need cuz setUser() is useless in remoteRepo
//  SetUserUseCase(remoteRepo).setUser(User())
  SetUserUseCase(localRepo).setUser(User())
  SetUserUseCase(repo).setUser(User())
}
