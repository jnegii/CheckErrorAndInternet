# Check Internet and automatically handle other errors

A short code which can be used to solve all your problems

[![API](https://img.shields.io/badge/API-14%2B-yellow.svg?style=flat-square)](https://android-arsenal.com/api?level=16)


![alt text](https://github.com/jnegii/CheckErrorAndInternet/blob/master/image1.jpeg)
![alt text](https://github.com/jnegii/CheckErrorAndInternet/blob/master/image2.jpeg)



## Setup

#### Gradle:

```java
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
```

```java
   	dependencies {
	        implementation 'com.github.jnegii:CheckErrorAndInternet:3.1.2'
	}
```

#### Maven:

```xml
  <repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
```


```xml
 <dependency>
	    <groupId>com.github.jnegii</groupId>
	    <artifactId>CheckErrorAndInternet</artifactId>
	    <version>3.1.1</version>
	</dependency>
```

## Usage

If you want to check internet connection is available or not, if not available show dialog 
```java
              //check will return boolean value that true if internet exist or not
              boolean check=    new ErrorDialog.Builder(MainActivity.this)
                .setBackgroundGradient(getResources().getColor(R.color.colorAccent),getResources().getColor(R.color.colorPrimaryDark))
                        .setCancelButtonStrokeColor(getResources().getColor(R.color.greenYellow))
                        .setCancelButtonTextColor(getResources().getColor(R.color.dark_red))
                        .setReryButtonTextColor(getResources().getColor(R.color.dark_goldenrod))
                        .setReryButtonColor(getResources().getColor(R.color.light_pink))
                        .setErrorOccuredHeading("")
                        .setErrorOccuredSubText("")
                        .setNoInternetHeading("")
                        .setNoInternetSubText("")
                        .setRetryButtonClickListner(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setCancelButtonClickListner(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .buildCheckInternetOnly();
                

```







Use this to Check Internet first if available and other error orrcured will be shown

```java
   new ErrorDialog.Builder(MainActivity.this)
                        .setBackgroundGradient(getResources().getColor(R.color.colorAccent),getResources().getColor(R.color.colorPrimaryDark))
                        .setCancelButtonStrokeColor(getResources().getColor(R.color.greenYellow))
                        .setCancelButtonTextColor(getResources().getColor(R.color.dark_red))
                        .setReryButtonTextColor(getResources().getColor(R.color.dark_goldenrod))
                        .setReryButtonColor(getResources().getColor(R.color.light_pink))
                        .setErrorOccuredHeading("")
                        .setErrorOccuredSubText("")
                        .setNoInternetHeading("")
                        .setNoInternetSubText("")
                        .setRetryButtonClickListner(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                               
                            }
                        })
                        .setCancelButtonClickListner(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                
                            }
                        })
                        .build();

```



## Versions

#### 3.1.2

Callbacks added

