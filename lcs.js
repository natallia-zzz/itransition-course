var http=require('http');
http.createServer(function(e,s){if(process.argv.length>2){var a=process.argv.slice(2),l=a.length,f=a[0],r="",t="",k=1;for(var i=0;i<f.length;i++){for(var j=i+1;j<f.length+1;j++){t=f.slice(i,j);
for(k=1;k<l;k++){if(!a[k].includes(t)){break;}}if(k==l&&r.length<t.length){r=t;}}}console.log(r);}else{console.log("nothing entered");}}).listen(8080);