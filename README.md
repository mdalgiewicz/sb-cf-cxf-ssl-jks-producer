**Spring Boot Contract First CXF Soap Producer**
-Spring Boot
-Cxf, Contract First Soap Consumer
-SSL (JKS)
-Lombok

Tworzenie keystore"
keytool -genkeypair -alias producerkey -keyalg RSA -dname "CN=localhost,OU=Example Org Unit,O=Dalgim,L=Warsaw,S=Warsaw,C=PL" -keypass P@ssw0rd -keystore producer-keystore.jks -storepass P@SSWORD

Wyeksportowanie certyfikatu serwera
keytool -exportcert -alias producerkey -file producer-public.cer -keystore producer-keystore.jks -storepass P@SSWORD

Utworzenie truststore dla klienta usługi, dodanie certyfikatu serwera
keytool -import -file consumer-public.cer -alias consumer -keystore producer-truststore.jks

