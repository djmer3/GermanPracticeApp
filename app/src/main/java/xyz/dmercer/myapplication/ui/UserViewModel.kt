/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *//*


package xyz.dmercer.myapplication.ui

import androidx.lifecycle.ViewModel
import io.reactivex.Completable
import io.reactivex.Flowable
import xyz.dmercer.myapplication.persistence.Question
import xyz.dmercer.myapplication.persistence.QuestionDAO

*/
/**
 * View Model for the [UserActivity]
 *//*

class UserViewModel(private val dataSource: QuestionDAO) : ViewModel() {

    */
/**
     * Get the user name of the user.

     * @return a [Flowable] that will emit every time the user name has been updated.
     *//*

    // for every emission of the user, get the user name
    fun userName(): Flowable<String> {
        return dataSource.getById(USER_ID)
                .map { user -> user.question }
    }

    */
/**
     * Update the user name.
     * @param userName the new user name
     * *
     * @return a [Completable] that completes when the user name is updated
     *//*

    fun updateUserName(userName: String): Completable {
        val user = Question(USER_ID, userName, "")
        return dataSource.insert(user)
    }

    companion object {
        // using a hardcoded value for simplicity
        const val USER_ID = "1"
    }
}
*/
