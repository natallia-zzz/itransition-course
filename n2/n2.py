def main():
	mypath = "/Users/natalliazzz/itransition course/n2/files"
	from os import listdir
	from os.path import isfile, join
	onlyfiles = [f for f in listdir(mypath) if isfile(join(mypath, f))]
	for i in onlyfiles:
		print(i)


if __name__ == '__main__':
	main()