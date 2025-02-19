// repalce chars
int indexes = str.indexOf(word);


char[] output = str.toCharArray();
for (int i = 0; i< str.length(); i++) {
	output[i] = '+';
}
int lastIndex = 0;

while (str.indexOf(word,lastIndex) != -1) {
	lastIndex = str.indexOf(word,lastIndex);
	for (int c = 0; c < word.length(); c++) {
		output[lastIndex + c] = word.charAt(c);
	}
	lastIndex++;
}

return String.valueOf(output);


// oneTwo

char[] output = str.substring(0,str.length() - str.length()%3).toCharArray();

if (str.length() - str.length()%3 == 0) {
	return "";
}

for (int i = 0; i < str.length() - str.length()%3; i+=3){
	char a = output[i];
	char b = output[i+1];
	char c = output[i+2];

	output[i] = b;
	output[i+1] = c;
	output[i+2] = a;
}
return String.valueOf(output);
