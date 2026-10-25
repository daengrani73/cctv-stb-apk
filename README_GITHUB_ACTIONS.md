
# Cara Dapat APK Tanpa Android Studio (GitHub Actions)

1. Upload folder `cctv-stb-android6` ini ke repo kamu https://github.com/alijayanet/cctv-monitoring
   - bisa via `git add cctv-stb-android6` lalu push
   - ATAU drag & drop di github.com > Add file > Upload files

2. Setelah push, buka di GitHub: Tab `Actions`

3. Klik workflow `Build STB APK Android 6` > `Run workflow`

4. Tunggu 3-5 menit, nanti muncul artifact `CCTV-STB-Monitor-Android6`

5. Download artifact itu, extract, dapat file `app-debug.apk`

6. Install di STB Android 6!

Ganti IP default: Edit file `cctv-stb-android6/app/src/main/java/net/alijaya/cctvmonitor/MainActivity.kt` line DEFAULT_URL sebelum push.
