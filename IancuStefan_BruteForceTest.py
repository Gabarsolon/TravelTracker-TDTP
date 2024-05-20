from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from time import sleep
import matplotlib.pyplot as plt

driver = webdriver.Chrome()  

url = "http://localhost:5173" 

usernames = [
    "user1", "user2", "user3", "user4", "user5", 
    "user6", "user7", "user8", "user9", "user10"
]

passwords = [
    "password1", "password2", "password3", "password4", "password5", 
    "password6", "password7", "password8", "password9", "password10"
]

success_count = 0
failure_count = 0

driver.get(url)

for username in usernames:
    for password in passwords:
        try:
            username_field = driver.find_element(By.ID, "username")
            username_field.clear()
            username_field.send_keys(username)

            password_field = driver.find_element(By.ID, "password")
            password_field.clear()
            password_field.send_keys(password)

            login_button = driver.find_element(By.CLASS_NAME, "button1")
            login_button.click()

            sleep(0.05)

            if "Login successful!" in driver.page_source:
                print(f"Login successful with username: {username} and password: {password}")
                success_count += 1
            else:
                print(f"Login failed for username: {username} and password: {password}")
                failure_count += 1

            driver.get(url)

        except Exception as e:
            print(f"An error occurred: {e}")
            failure_count += 1

driver.quit()

labels = ['Success', 'Failure']
sizes = [success_count, failure_count]
colors = ['#4CAF50', '#F44336']
explode = (0.1, 0)  

plt.figure(figsize=(8, 8))
plt.pie(sizes, explode=explode, labels=labels, colors=colors, autopct='%1.1f%%',
        shadow=True, startangle=140)
plt.axis('equal')  

plt.title('Brute Force Login Test Results')
plt.show()