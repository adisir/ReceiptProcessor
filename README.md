# Receipt Processor

A microservice that handles receipts.

---

## Getting Started with Docker

### 1. Build the Docker Image

To build the Docker image for this project, run the following command:

```bash
docker build -t receiptprocessor .
```

### 2. Run the Docker Image
To run the Docker image for this project, run the following command:
```bash
docker run --name receiptprocessor -d -p 8080:8080 receiptprocessor
```
