#define pinTrig 3
#define pinEcho 2
#define pinBuz 13

long waktu,jarak;

void setup() {
    Serial.begin(9600);
    pinMode(pinBuz, OUTPUT);
    pinMode(pinTrig, OUTPUT);
    pinMode(pinEcho, INPUT);
}

void loop() {
    digitalWrite(pinTrig, LOW);
    delayMicroseconds(2);
    digitalWrite(pinTrig, HIGH);
    delayMicroseconds(10);
    digitalWrite(pinTrig, LOW);


    waktu = pulseIn(pinEcho, HIGH);
    jarak = waktu / 58.2;

    if (jarak < 250  && jarak >= 200) {
      tone(pinBuz, 100);
      delay(50);
      noTone(pinBuz);
      delay(200);
    } 
    
    else if (jarak < 200  && jarak >= 150) {
        tone(pinBuz, 200);
        delay(50);
        noTone(pinBuz);
        delay(150);
    }

    else if(jarak < 150  && jarak >= 100) {
        tone(pinBuz, 300);
        delay(50);
        noTone(pinBuz);
        delay(100);
    }

    else if(jarak < 100  && jarak >= 50) {
        tone(pinBuz, 400);
        delay(50);
        noTone(pinBuz);
        delay(50);
    }

    else if(jarak < 50  && jarak >= 2) {
        tone(pinBuz, 300);
        delay(50);
        noTone(pinBuz);
    }

    else{
        noTone(pinBuz);
    }
}
