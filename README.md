
# CCTV STB Monitor - Android 6 APK Project
By alijayanet - Optimized for STB Bekas (B860H, HG680P, etc)

## Cara Build APK (paling gampang)
1. Download Android Studio (https://developer.android.com/studio)
2. Open folder ini: cctv-stb-android6
3. Buka app/src/main/java/net/alijaya/cctvmonitor/MainActivity.kt
   Ganti line: private val DEFAULT_URL = "http://192.168.1.100:3003"
   Jadi IP server cctv-monitoring kamu, misal http://192.168.1.10:3003
4. Build > Build APK(s) > Build > Generate APK
5. APK ada di app/build/outputs/apk/debug/app-debug.apk
6. Copy ke Flashdisk, install di STB via File Manager

## Kenapa work di Android 6?
- minSdk 21, targetSdk 33 (bukan 34 yang bikin crash di STB)
- ExoPlayer 2.18.7 (versi terakhir support API 21)
- WebView dengan mixedContentMode ALWAYS_ALLOW + cleartextTraffic true (biar http:// bisa)
- Leanback launcher biar muncul di home STB
- Landscape + DPAD remote support

## Konek ke cctv-monitoring mu
Pastikan:
- STB dan server CCTV satu WiFi / LAN
- Server jalan: http://IP:3003 bisa dibuka di HP dulu
- Kalau HLS hitam di STB, update views kamu inject hls.js (sudah aku siapkan di index.js)

Mau versi RTSP Direct tanpa server? Bilang aja, gue tambahin ExoPlayer RTSP player activity.

- Makassar Panas Crew -
