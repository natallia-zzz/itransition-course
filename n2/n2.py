import hashlib

def file_contents_hash(path):
	file = open(path)
	line = file.read()
	file.close()
	bline = str.encode(line)
	return hashlib.sha256(bline).hexdigest()

def main():
	mypath = "/Users/natalliazzz/itransition course/n2/files"
	from os import listdir
	from os.path import isfile, join
	for i in listdir(mypath):
		if not i.startswith("."): #ignore system files
			print(i + " " + file_contents_hash(join(mypath, i)))


if __name__ == '__main__':
	main()