var http = require('http');

http.createServer(function (req, res) {
	if(process.argv.length > 2){
		var arrayOfStrings = process.argv.slice(2);
		var lengthOfArr = arrayOfStrings.length;
		var firstWord = arrayOfStrings[0];
		var result = "";
		var temp = "";
		var k = 1;
		for(var i = 0; i < firstWord.length; i++){
			for (var j = i + 1; j < firstWord.length + 1 ; j++) {
				temp = firstWord.slice(i,j);
				for(k = 1; k < lengthOfArr ; k++){
					if(!arrayOfStrings[k].includes(temp)){
						break;
					}	
				}
				if(k == lengthOfArr && result.length < temp.length){
					result = temp;
				}
			}
		}
		console.log(result);
	}
	else{
		console.log("nothing entered");
	}
}).listen(8080);