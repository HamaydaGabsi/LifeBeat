/*

*/
#include <ESP8266Firebase.h>
#include <ESP8266WiFi.h>

#define _SSID "ENTER HERE"          // Your WiFi SSID
#define _PASSWORD "ENTER HERE"      // Your WiFi Password
#define REFERENCE_URL "ENTER HERE"  // Your Firebase project reference url

Firebase firebase(REFERENCE_URL);
int randomNumber;
int PulseSensorPurplePin =0;
unsigned long lastMillis =0;
unsigned long previousMillis = 0;
const long interval = 5000;
int Signal;
int threshold = 580;

void setup() {
    Serial.begin(115200);
  pinMode(LED_BUILTIN, OUTPUT);
  digitalWrite(LED_BUILTIN, LOW);
  WiFi.mode(WIFI_STA);
  WiFi.disconnect();
  delay(1000);

  // Connect to WiFi
  Serial.println();
  Serial.println();
  Serial.print("Connecting to: ");
  Serial.println(_SSID);
  WiFi.begin(_SSID, _PASSWORD);

  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print("-");
  }

  Serial.println("");
  Serial.println("WiFi Connected");

  // Print the IP address
  Serial.print("IP Address: ");
  Serial.print("http://");
  Serial.print(WiFi.localIP());
  Serial.println("/");
  digitalWrite(LED_BUILTIN, HIGH);
    
  Serial.begin(9600);
  pinMode(pinSignal,INPUT);
  
}

void loop() {
    int total = 0;
    for (int i=0;i<numSamples;i++){
      total += analogRead(pinSignal);
      delay(1)
    }
    int average = total / numSamples;
    Serial.println(average);
    delay(100);
    
    StaticJsonDocument<200> doc;
    doc["time_id"]=Signal-566;
    doc["time_idd"]=Signal;
    doc["Signal"]=sensor();
    
    char jsonBuffer[512];
    serializeJson(doc,jsonBuffer);
    client.publish(firebase(REFERENCE_URL))
    
    
}
