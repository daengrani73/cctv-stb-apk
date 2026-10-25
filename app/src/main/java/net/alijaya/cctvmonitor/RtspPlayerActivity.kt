
package net.alijaya.cctvmonitor

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.PlayerView

class RtspPlayerActivity : AppCompatActivity() {
    private var player: ExoPlayer? = null
    private lateinit var playerView: PlayerView
    private lateinit var rtspInput: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rtsp)

        playerView = findViewById(R.id.player_view)
        rtspInput = findViewById(R.id.rtsp_input)
        val btnPlay = findViewById<Button>(R.id.btn_play)
        val btnStop = findViewById<Button>(R.id.btn_stop)
        val btnBack = findViewById<Button>(R.id.btn_back)

        // contoh RTSP, ganti sesuai kamera mu
        rtspInput.setText("rtsp://admin:admin@192.168.1.64:554/stream1")

        btnPlay.setOnClickListener { playRtsp(rtspInput.text.toString()) }
        btnStop.setOnClickListener { stopPlayer() }
        btnBack.setOnClickListener { finish() }
    }

    private fun playRtsp(url: String) {
        stopPlayer()
        player = ExoPlayer.Builder(this).build().also { exo ->
            playerView.player = exo
            val mediaItem = MediaItem.fromUri(url)
            exo.setMediaItem(mediaItem)
            exo.prepare()
            exo.playWhenReady = true
        }
    }

    private fun stopPlayer() {
        player?.release()
        player = null
    }

    override fun onStop() {
        super.onStop()
        stopPlayer()
    }
}
