class User:
    def __init__(self, username, email, password):
        self.username = username
        # underscore means protected
        self._email = email
        self._password = password
