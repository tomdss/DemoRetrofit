package com.example.mydagger1

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mydagger1.network.MovieApi
import com.example.mydagger1.network.model.MovieTopRateResponse
import com.example.mydagger1.utils.ImageLoader
import com.github.ybq.android.spinkit.style.*
import com.squareup.picasso.Picasso
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class MainActivity : DaggerAppCompatActivity() {

    private var spinKit: ProgressBar? = null

    @Inject
    lateinit var movieApi: MovieApi

    @Inject
    lateinit var imageLoader: ImageLoader

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    @SuppressLint("SetTextI18n", "CheckResult")
    private fun initViews() {
        spinKit = findViewById<ProgressBar>(R.id.spinKit)

        val loadingSpinkitStyle = Circle()
        spinKit?.indeterminateDrawable = loadingSpinkitStyle

        val movieMap: HashMap<String, Any> = HashMap()
        movieMap["api_key"] = "9b7967dd934d718a778460fa84c793f1"
        movieMap["page"] = 1
        /*movieApi.getMovieTopRate(movieMap)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = {
                    val movie = it.results[1]
                    Toast.makeText(this@MainActivity, "Success", Toast.LENGTH_LONG).show()
                    imageLoader.loadImage(POSTER_URL_BASE + movie.posterPath, ivPoster)
                    tvPoint.text = "${movie.voteAverage}/10"
                    tvName.text = movie.title
                    spinKit?.visibility = View.GONE
                },
                onError = {
                    Toast.makeText(
                        this@MainActivity,
                        "Error = ${it.message}",
                        Toast.LENGTH_LONG
                    ).show()
                    spinKit?.visibility = View.GONE
                })*/


        val call = movieApi.getMovieTopRate(movieMap)
        call.enqueue(object: Callback<MovieTopRateResponse>{
            override fun onFailure(call: Call<MovieTopRateResponse>, t: Throwable) {
                Toast.makeText(
                    this@MainActivity,
                    "Error = ${t.message}",
                    Toast.LENGTH_LONG
                ).show()
                spinKit?.visibility = View.GONE
            }

            override fun onResponse(
                call: Call<MovieTopRateResponse>,
                response: Response<MovieTopRateResponse>
            ) {
                val movie = response.body()?.results?.get(2)
                Toast.makeText(this@MainActivity, "Success", Toast.LENGTH_LONG).show()
                imageLoader.loadImage(POSTER_URL_BASE + movie?.posterPath, ivPoster)
                tvPoint.text = "${movie?.voteAverage}/10"
                tvName.text = movie?.title
                spinKit?.visibility = View.GONE
            }

        })


    }


    companion object {
        const val POSTER_URL_BASE = "https://image.tmdb.org/t/p/w500"
    }

}