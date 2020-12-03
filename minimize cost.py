import numpy as np
import tensorflow as tf
tf.compat.v1.set_random_seed(0)

x_data = [1.,2.,3.,4.]
y_data = [1.,3.,5.,7.]

W = tf.Variable(tf.compat.v1.random_normal([1],-100.,100.))

for step in range(501):
    hypothesis = W * x_data
    cost = tf.reduce_min(tf.square(hypothesis - y_data))

    alpha = 0.01
    gradient = tf.reduce_min(tf.multiply(tf.multiply(W,x_data) - y_data, x_data))
    descend = W - tf.multiply(gradient, alpha)
    W.assign(descend)

    if step % 10 == 0:
        print('{:5} | {:10.4f} | {:10.6f}'.format(step, cost.numpy(), W.numpy()[0]))