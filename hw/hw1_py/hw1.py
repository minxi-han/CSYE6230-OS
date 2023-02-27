import threading

def task():
    print("This is a task")

threads = []
for i in range(4):
    t = threading.Thread(target=task)
    t.start()
    threads.append(t)

for t in threads:
    t.join()



import random
import time
import multiprocessing

def multiply_and_sum(arr):
    random.seed()
    sum = 0
    for i in range(len(arr)):
        random_value = random.uniform(0.1, 0.9)
        sum += arr[i] * random_value
    return sum

def serial_multiply_and_sum(arr):
    random.seed()
    sum = 0
    for i in range(len(arr)):
        random_value = random.uniform(0.1, 0.9)
        sum += arr[i] * random_value
    return sum

if __name__ == '__main__':
    arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

    start_time = time.time()
    result = multiply_and_sum(arr)
    end_time = time.time()
    print(f"Parallel result: {result} in {end_time - start_time:.5f} seconds")

    start_time = time.time()
    result = serial_multiply_and_sum(arr)
    end_time = time.time()
    print(f"Serial result: {result} in {end_time - start_time:.5f} seconds")
