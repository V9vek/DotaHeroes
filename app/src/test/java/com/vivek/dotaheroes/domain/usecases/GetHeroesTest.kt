package com.vivek.dotaheroes.domain.usecases

import com.google.gson.GsonBuilder
import com.vivek.dotaheroes.data.cache.FakeHeroDatabase
import com.vivek.dotaheroes.data.network.data.HeroDataValid
import com.vivek.dotaheroes.data.network.data.HeroDataValid.NUM_HEROES
import com.vivek.dotaheroes.data.remote.DotaHeroesApi
import com.vivek.dotaheroes.data.repository.FakeHeroCache
import com.vivek.dotaheroes.data.repository.FakeHeroNetwork
import com.vivek.dotaheroes.util.Resource
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.HttpURLConnection

class GetHeroesTest {

    // system in test
    private lateinit var getHeroes: GetHeroes

    private lateinit var mockWebServer: MockWebServer
    private lateinit var fakeHeroDatabase: FakeHeroDatabase
    private lateinit var fakeHeroCache: FakeHeroCache
    private lateinit var fakeHeroNetwork: FakeHeroNetwork

    @Before
    fun setup() {
        // cache dependencies
        fakeHeroDatabase = FakeHeroDatabase()
        fakeHeroCache = FakeHeroCache(db = fakeHeroDatabase)

        // network dependencies
        mockWebServer = MockWebServer()
        mockWebServer.start()
        // TODO: try to change this url
        val mockBaseUrl = mockWebServer.url(path = "/api/")
        val mockApi = Retrofit.Builder()
            .baseUrl(mockBaseUrl)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(DotaHeroesApi::class.java)

        fakeHeroNetwork = FakeHeroNetwork(api = mockApi)

        getHeroes = GetHeroes(
            api = fakeHeroNetwork,
            cache = fakeHeroCache
        )
    }

    @Test
    fun getHeroes_success(): Unit = runBlocking {
        // mockWebServer setup and schedule some response
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(HttpURLConnection.HTTP_OK)
                .setBody(body = HeroDataValid.data)
        )
        // println(fakeHeroNetwork.getHeroes())

        // confirm the cache is empty, before any use-case has been executed
        assert(fakeHeroCache.getAllHeores().isEmpty())

        // execute the use-case
        val emissions = getHeroes.execute().toList()

        // after executing use-case, cache is no longer empty
        assert(fakeHeroCache.getAllHeores().size == NUM_HEROES)

        assert((emissions[0] as Resource.Loading).isLoading)

        assert((emissions[1] as Resource.Success).data?.size == 0)

        assert((emissions[2] as Resource.Success).data?.size == NUM_HEROES)

        assert((emissions[3] as Resource.Loading).isLoading.not())
    }

    @After
    fun teardown() {
        mockWebServer.shutdown()
    }
}




























