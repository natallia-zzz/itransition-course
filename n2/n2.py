import hashlib

def file_contents_hash(path):
	file = open(path)
	line = file.read()
	file.close()
	bline = str.encode(line)
	return hashlib.sha3_256(bline).hexdigest()

def main():
	from os import listdir,getcwd
	from os.path import join, abspath
	mypath = abspath(getcwd())
	for i in listdir(mypath):
		if not i.startswith("."): #ignore system files
			print(i + " " + file_contents_hash(join(mypath, i)))


if __name__ == '__main__':
	main()