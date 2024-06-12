reference-site:
	C:\nobackup\jonpark-java\namoosori-spring5
		https://github.com/soomst/namoosori-spring5

java-static:
	static method 는 static variable 만을 이용해야 한다.

	https://mangkyu.tistory.com/47

		일반적으로 우리가 만든 Class는 Static 영역에 생성되고, new 연산을 통해 생성한 객체는 Heap영역에 생성됩니다. 객체의 생성시에 할당된 Heap영역의 메모리는 Garbage Collector를 통해 수시로 관리를 받습니다. 하지만 Static 키워드를 통해 Static 영역에 할당된 메모리는 모든 객체가 공유하는 메모리라는 장점을 지니지만, Garbage Collector의 관리 영역 밖에 존재하므로 Static을 자주 사용하면 프로그램의 종료시까지 메모리가 할당된 채로 존재하므로 자주 사용하게 되면 시스템의 퍼포먼스에 악영향을 주게 됩니다.
		[ Static 변수 특징 ]Static 변수는 클래스 변수이다.객체를 생성하지 않고도 Static 자원에 접근이 가능하다..Static 변수와 static 메소드는 Static 메모리 영역에 존재하므로 객체가 생성되기 이전에 이미 할당이 되어 있습니다. 그렇기 때문에 객체의 생성없이 바로 접근(사용)할 수 있습니다. 
		출처: https://mangkyu.tistory.com/47 [MangKyu's Diary:티스토리]

