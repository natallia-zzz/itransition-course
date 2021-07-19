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
	onlyfiles = [f for f in listdir(mypath) if isfile(join(mypath, f))]
	for i in onlyfiles:
		print(i)
		print(file_contents_hash(join(mypath, f)))


if __name__ == '__main__':
	main()