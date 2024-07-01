Wymagania wstępne:
Aby uruchomić tę aplikację, upewnij się, że masz zainstalowane następujące narzędzia:

JDK (Java Development Kit) - preferowana wersja 11 lub wyższa
Maven - do zarządzania zależnościami i budowania projektu
Docker - do tworzenia kontenerów i uruchamiania aplikacji

Budowanie projektu:

mvn clean package -Dmaven.test.skip=true

docker-compose up --build

Wyłączanie projektu:

docker-compose down


Aplikacja jest dostępna pod:

http://localhost:3000/
