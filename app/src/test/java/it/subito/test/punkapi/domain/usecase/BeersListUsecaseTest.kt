package it.subito.test.punkapi.domain.usecase


import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.stub
import it.subito.test.punkapi.domain.entity.local.SimpleBeer
import it.subito.test.punkapi.domain.repository.Repository
import it.subito.test.punkapi.library.android.entity.Result
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.CoreMatchers.`is`
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class BeersListUsecaseTest {


    private var correctBeerListFake = mutableListOf(
        SimpleBeer(1, "url1", "PunkIpa", "good beer 1", "04-2012"),
        SimpleBeer(2, "url2", "PunkIpa2", "good beer 2", "04-2012"),
        SimpleBeer(3, "url3", "PunkIpa3", "good beer 3", "04-2012"),
        SimpleBeer(4, "url4", "PunkIpa4", "good beer 4", "04-2012"),
    )
    private val correctResult: Result<List<SimpleBeer>> = Result.Success(correctBeerListFake)
    private val errorResult: Result<List<SimpleBeer>> = Result.Error(Exception("error"))


    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @ExperimentalCoroutinesApi
    @Test
    fun verify_simple_paginated_correct_call_correct_answer() =
        runBlockingTest {
            val mock: Repository = mock()
            mock.stub {
                onBlocking { fetchAllBeerPaginated(1) } doReturn correctResult
            }
            val toTestClass = BeersListUsecase(mock)
            val retrieveBeersPaginated = toTestClass.retrieveBeersPaginated(1)

            Assert.assertThat(retrieveBeersPaginated.succeded, `is`(true))
        }

    @ExperimentalCoroutinesApi
    @Test
    fun verify_simple_paginated_wrong_call_correct_answer() =
        runBlockingTest {
            val mock: Repository = mock()
            mock.stub {
                onBlocking { fetchAllBeerPaginated(1) } doReturn errorResult
            }
            val toTestClass = BeersListUsecase(mock)
            val retrieveBeersPaginated = toTestClass.retrieveBeersPaginated(1)

            Assert.assertThat(retrieveBeersPaginated.failed, `is`(true))
        }

//
}