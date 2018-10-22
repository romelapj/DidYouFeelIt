package com.romelapj.didyoufeelit

import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    /** URL for earthquake data from the USGS dataset  */
    private val USGS_REQUEST_URL = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2016-01-01&endtime=2016-05-02&minfelt=50&minmagnitude=5"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        EarthquakeAsyncTask().execute(USGS_REQUEST_URL)
    }

    /**
     * Update the UI with the given earthquake information.
     */
    fun updateUi(earthquake: Event) {
        val titleTextView = findViewById<View>(R.id.title) as TextView
        titleTextView.text = earthquake.title

        val tsunamiTextView = findViewById<TextView>(R.id.number_of_people)
        tsunamiTextView.text = getString(R.string.num_people_felt_it, earthquake.numOfPeople)

        val magnitudeTextView = findViewById<TextView>(R.id.perceived_magnitude)
        magnitudeTextView.text = earthquake.perceivedStrength
    }

    inner class EarthquakeAsyncTask : AsyncTask<String?, Void, Event>() {

        override fun doInBackground(vararg urls: String?): Event? {
            return urls[0]?.let {
                Utils.fetchEarthquakeData(it)
            }
        }

        override fun onPostExecute(result: Event?) {
            result?.let {
                updateUi(result)
            }
        }

    }
}
