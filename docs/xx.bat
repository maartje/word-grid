for %%A IN ("*.wav") DO "C:\Program Files (x86)\FFmpeg\ffmpeg.exe" -i "%%A" -aq 500 "newfiles\%%A.m4a"
pause



