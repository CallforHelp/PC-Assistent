@echo off
echo Sichere Registry ...

REG EXPORT HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Windows\CurrentVersion\OEMInformation D:\Autostart.reg

echo Registry gesichert!