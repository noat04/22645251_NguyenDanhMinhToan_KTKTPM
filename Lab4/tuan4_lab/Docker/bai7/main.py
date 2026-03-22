import os

app_env = os.environ.get('APP_ENV', 'not set')
print(f"Environment variable APP_ENV is: {app_env}")
