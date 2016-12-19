cd vagrant-lamp-wordpress-install-wordpress
CALL vagrant up
set PATH=%PATH%;C:\Program Files\Git\usr\bin
CALL start http://localhost:8888
cd ..
cd finalProject
tests_and_report.bat