# SeleniumStudy

## Selenium 이란 ?
- Selenium 은 브라우저를 자동화하여 웹 어플리케이션 테스트를 하기 위한 포터블 프레임워크이다.
- 여러 언어에서 웹 드라이버를 통해 웹 자동화 테스트 혹은 웹 자동화를 도와주는 라이브러리 이다.
- 지원 브라우저는 Fire Fox, Chrome, IE 등이 있고 Chrome 이 제일 보편적이나 IE 드라이버를 사용하였다.
- 언어는 주로 파이썬을 많이 이용하지만 이번 예제에서는 Java 를 사용하였다.
- Webdriver가 실행되면 서버처럼 구동되며 구동된 webdriver는 http://<pc_ip>:<webdriver port>다음과 같이 http프로토콜로 명령을 직접 날리고 확인 할 수가 있지만, 보통 webdriver에 명령을 날려주는 역할은 selenium에서 제공한 언어별 library를 통해서 수행한다. library 내에는 browser를 조작해주는 다양한 function(browser open, find, click, doubleclick ...)들이 존재한다.
- webdriver의 API를 통해 브라우저를 제어하기 때문에 자바스크립트에 의해 동적으로 생성되는 사이트의 데이터를 크롤링할 때 매우 유용하게 사용되는 스크래핑 도구입니다.

 get(String url) : 브라우저 인스턴스에서 브라우저를 실행시키고, 주어진 URL을 open하는 메소드다.<br/>
 getWindowHandle() : 싱글 창(window)를 다루는데 사용되며, return type은 문자다. 또한, focused된 브라우저를 리턴할 것이다. <br/>
 getWindowHandles() : 멀티 창을 다루는데  사용되며, return type은 Set이다. 또한, Selenium Webdriver로 열린 브라우저의 모든 핸들을 반환할 것이다.<br/>
 close() : 이 명령어는 현재 포커스되어 있는 브라우저 창을 닫는데 사용된다.<br/>
 quit() : 이 메소드는 모든 브라우저 창을 닫는데 사용된다. 또한 Webdriver session은 종료된다.<br/>
 getTitle() : 이 메소드는 현재 동작중인 웹페이지의 제목을 가져오는데 사용된다.<br/>
 findElement() : 현재 사용중인 웹페이지 내의 첫번째 엘리먼트를 찾는다.<br/>
 sendKeys() : Edit Box나 Text Box의 값을 넣는다.<br/>
 clear() : Edit Box나 Text Box의 값을 제거한다.<br/>
 click() : 엘리먼트(Button, Link, CheckBox 등)를 클릭한다.<br/>
