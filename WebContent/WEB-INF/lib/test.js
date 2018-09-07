document.write("<font color=\"orange\">Javascriptにてメッセージを出力しています。</font>")

function check(){


	var flag = 0;

	if(document.test.empid.value == ""){ // 「お名前」の入力をチェック
		flag = 1;
	}

	if(flag){

		window.alert('必須項目に未入力がありました'); // 入力漏れがあれば警告ダイアログを表示
		console.log("あああああああああああああああ");
		return false; // 送信を中止

	}
	else{

		return true; // 送信を実行

	}
}