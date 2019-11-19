package com.ayokunlepaul.remote.utils

import org.json.JSONException
import org.json.JSONObject
import retrofit2.HttpException
import java.io.IOException
import java.net.*

object BlockchainGrafikRemoteErrorExtractor {

    fun extractErrorMessage(throwable: Throwable): String {
        return when (throwable) {
            is ConnectException -> BlockchainGrafikRemoteErrorMessages.CONNECT_EXCEPTION
            is UnknownHostException -> BlockchainGrafikRemoteErrorMessages.UNKNOWN_HOST_EXCEPTION
            is SocketTimeoutException -> BlockchainGrafikRemoteErrorMessages.SOCKET_TIME_OUT_EXCEPTION
            is UnknownServiceException -> throwable.localizedMessage ?: BlockchainGrafikRemoteErrorMessages.UNKNOWN_NETWORK_EXCEPTION
            is ProtocolException -> BlockchainGrafikRemoteErrorMessages.PROTOCOL_EXCEPTION
            is HttpException -> {
                return if (throwable.code() == 403) {
                    val message = throwable.message()
                    return message ?: BlockchainGrafikRemoteErrorMessages.FORBIDDEN_EXCEPTION
                } else try {
                    val response = throwable.response()
                    val json = JSONObject(response?.errorBody()?.string()!!)
                    if (json.has("status")) json["status"] as String
                    else json["error"] as String
                } catch (e1: JSONException) {
                    BlockchainGrafikRemoteErrorMessages.UNKNOWN_NETWORK_EXCEPTION
                } catch (e1: IOException) {
                    BlockchainGrafikRemoteErrorMessages.UNKNOWN_NETWORK_EXCEPTION
                }
            }
            else -> BlockchainGrafikRemoteErrorMessages.UNKNOWN_NETWORK_EXCEPTION
        }
    }
}