"""
This was introduced in 3.10
which is similar to switch case in other language
"""

def http_status(status):
    match status:
        case 200:
            return "ok"
        case 404:
            return "Not Found"
        case 500:
            return "internal server error"
        case _: # this is the case when it wont match with the given value
            return "unknown status"

