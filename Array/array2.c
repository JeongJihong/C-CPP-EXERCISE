#include <stdio.h>
#include <stdlib.h>

int main(void)
{
	int n;
	int** arr;
	FILE* fp;

	scanf("%d", &n);
	arr = (int**)malloc(sizeof(int*) * n);
	for (int i = 0; i < n; ++i)
		arr[i] = (int*)malloc(sizeof(int) * n);

	for (int i = 0; i < n; ++i)
		for (int j = 0; j < n; ++j)
			arr[i][j] = (i + 1) * (j + 1);

	//print
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < n; ++j) {
			printf("%2d ", arr[i][j]);
		}
		printf("\n");
	}

	//txt print
	fp = fopen("array.txt", "wt");
	if (!fp) {
		printf("File Error");
		return -1;
	}
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < n; ++j) {
			fprintf(fp, "%2d ", arr[i][j]);
		}
		fprintf(fp, "\n");
	}

	for (int i = 0; i < n; ++i)
		free(arr[i]);
	free(arr);
	fclose(fp);
	return 0;
}